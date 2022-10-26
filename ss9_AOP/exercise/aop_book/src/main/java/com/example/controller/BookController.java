package com.example.controller;

import com.example.dto.BookDto;
import com.example.exception.EnoughBookException;
import com.example.exception.NoMoreBookException;
import com.example.model.Book;
import com.example.service.IBookRentalService;
import com.example.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    IBookService iBookService;

    @Autowired
    IBookRentalService iBookRentalService;

    @GetMapping("/")
    public String showBookList(@PageableDefault(value = 5)Pageable pageable,
                                 @RequestParam(defaultValue = "") String name,
                                 Model model){
        System.out.println(name);
        model.addAttribute("bookList", iBookService.findByBookTitleContaining(name, pageable));
        model.addAttribute("name",name);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("bookDto", new BookDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute BookDto bookDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model){
        new BookDto().validate(bookDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/create";
        }
        else{
            Book book = new Book();
            BeanUtils.copyProperties(bookDto, book);
            iBookService.save(book);
            redirectAttributes.addFlashAttribute("mess", "Add new successful!");
            return "redirect:/";
        }
    }

    @GetMapping("/view/{id}")
    public String showViewForm(@PathVariable int id, Model model){
        model.addAttribute("book", iBookService.findById(id));
        return "/view";
    }


    @GetMapping("/pay/{id}")
    public String showPayForm(@PathVariable int id, Model model) throws EnoughBookException {
        Book book = iBookService.findById(id);

        if (book.getAmount() == book.getBookTotal()){
            throw  new EnoughBookException();
        }
        else {
            book.setAmount(book.getAmount() + 1);
            iBookService.save(book);
            return "redirect:/";
        }

    }
    @ExceptionHandler(EnoughBookException.class)
    public String showEnoughBookExcetion(){
        return "/enoughBook";

    }

    @GetMapping("/borrow/{id}")
    public String showBorrowForm(@PathVariable int id , Model model) throws NoMoreBookException {
        Book book = iBookService.findById(id);
        if(book.getAmount()==0){
            throw new NoMoreBookException();
        }else {
            book.setAmount(book.getAmount()-1);
            iBookService.save(book);
            return "redirect:/";
        }
    }
    @ExceptionHandler(NoMoreBookException.class)
    public String showNoMoreBookException(){
        return "/noMoreBook";
    }



}

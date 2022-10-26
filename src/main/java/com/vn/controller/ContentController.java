package com.vn.controller;

import com.vn.model.Content;
import com.vn.model.Member;
import com.vn.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@AllArgsConstructor
public class ContentController {
    private final ContentService contentService;
    private final HttpServletRequest request;

    @GetMapping("/view_content")
    public String viewContent(Model model, @ModelAttribute("member") Member member) {
        List<Content> contentList = contentService.findByAuthorId(member.getId());
        model.addAttribute("list", contentList);
        model.addAttribute("content", new Content());
        return "view_content";
    }

    @GetMapping("/delete")
    public String delete(HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        contentService.delete(id);
        return "redirect:/view_content";
    }

    @GetMapping("/add_content")
    public String addContent(Model model) {
        model.addAttribute("content", new Content());
        return "add_content";
    }

    @PostMapping("/add_content")
    public String addCheck(@ModelAttribute("content") Content content) {
        Member member = new Member();
        content.setTitle(content.getTitle());
        content.setBrief(content.getBrief());
        content.setContent(content.getContent());
        content.setContentByMember(member);

        contentService.save(content);
        return "redirect:/home";
    }
}

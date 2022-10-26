package com.vn.controller;


import com.vn.model.Member;
import com.vn.repository.MemberRepository;
import com.vn.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("member", new Member());
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginCheck(Model model,
                             @ModelAttribute("member") Member member,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) throws Exception {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        return "redirect:/home";

    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/register")
    public String registerCheck(Model model,
                                @ModelAttribute("member") Member member,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) throws Exception {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        Member checkMem = memberService.findByUserAndEmail(member.getUsername(), member.getEmail());
        if (checkMem != null) {
            model.addAttribute("error", "Email or username is existed!");
            return "register";
        } else {
            memberService.save(member);
            return "redirect:/login";
        }
    }

    @GetMapping("/edit_profile")
    public String editProfile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("email", userDetails.getUsername());
        return "edit_profile";
    }

    @PostMapping("/edit_profile")
    public String editCheck(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("member") Member member) {
        member.setEmail(userDetails.getUsername());
        member.setFirstName(member.getFirstName());
        member.setLastName(member.getLastName());
        memberRepository.save(member);
        return "redirect:/home";
    }
}

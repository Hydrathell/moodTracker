package io.multiverse.moodtracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoodController {
    
    @Autowired
    private MoodRepo moodRepo;
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/moods")
    public String moods(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("user", principal.getClaims());
        return "moods";
    }
}

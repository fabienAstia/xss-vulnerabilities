package co.simplon.xss_vulnerabilities.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.xss_vulnerabilities.dtos.ForumView;
import co.simplon.xss_vulnerabilities.services.ForumService;

@RestController
@RequestMapping("/xss/forum")
@CrossOrigin("*")
public class ForumController {

    private final ForumService forumService;

    public ForumController(ForumService forumService) {
	this.forumService = forumService;
    }

    @GetMapping
    public ForumView getForumView() {
	return forumService.getForumView();
    }

}

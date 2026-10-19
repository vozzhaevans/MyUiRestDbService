package ru.vozzaeva.MyUiRestDbService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ru.vozzaeva.MyUiRestDbService.dao.StudyGroupRepository;
import ru.vozzaeva.MyUiRestDbService.entity.StudyGroup;

import java.util.Optional;

@Controller
public class StudyGroupController {

    private final StudyGroupRepository groupRepository;

    public StudyGroupController(
            StudyGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    public ModelAndView getAllGroups() {
        ModelAndView mav =
                new ModelAndView("list-groups");

        mav.addObject("groups", groupRepository.findAll());

        return mav;
    }

    @GetMapping("/addGroupForm")
    public ModelAndView addGroupForm() {
        ModelAndView mav =
                new ModelAndView("add-group-form");

        mav.addObject("group", new StudyGroup());

        return mav;
    }

    @PostMapping("/saveGroup")
    public RedirectView saveGroup(
            @ModelAttribute("group") StudyGroup group) {

        groupRepository.save(group);

        return new RedirectView("/groups");
    }

    @GetMapping("/showGroupUpdateForm")
    public ModelAndView showGroupUpdateForm(
            @RequestParam Long groupId) {

        Optional<StudyGroup> optionalGroup =
                groupRepository.findById(groupId);

        if (optionalGroup.isEmpty()) {
            return new ModelAndView("redirect:/groups");
        }

        ModelAndView mav =
                new ModelAndView("add-group-form");

        mav.addObject("group", optionalGroup.get());

        return mav;
    }

    @GetMapping("/deleteGroup")
    public RedirectView deleteGroup(
            @RequestParam Long groupId) {

        if (groupRepository.existsById(groupId)) {
            groupRepository.deleteById(groupId);
        }

        return new RedirectView("/groups");
    }
}
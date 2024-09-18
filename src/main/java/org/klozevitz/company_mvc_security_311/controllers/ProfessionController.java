package org.klozevitz.company_mvc_security_311.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.company_mvc_security_311.dao.ProfessionService;
import org.klozevitz.company_mvc_security_311.model.Profession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/professions")
@RequiredArgsConstructor
public class ProfessionController {
    private final ProfessionService professionService;

    @GetMapping
    public String professionsPage(Model model) {
        List<Profession> all = professionService.all();
        model.addAttribute("all", all);

        if (!model.containsAttribute("profession")) {
            // объект для привязки к форме и передачи в метод save
            Profession professionToSave = new Profession();
            model.addAttribute("profession", professionToSave);
        }
        return "/entities/professions";
    }

//    @PostMapping
//    public String save(@RequestParam String name, @RequestParam String note) {
//        professionService.save(new Profession(name, note));
//        return "redirect:/professions";
//    }

    @PostMapping
    public String save(Profession profession) {
        professionService.save(profession);
        return "redirect:/professions";
    }

    @GetMapping("/{id}")
    public String updatePage(@PathVariable int id, RedirectAttributes redirectAttributes) {
        // страница получает копию объекта из базы данных
        Optional<Profession> fromDB = professionService.findById(id);
        if (fromDB.isPresent()) {
            Profession professionToUpdate = fromDB.get();
            redirectAttributes.addFlashAttribute("profession", professionToUpdate);
        }
        return "redirect:/professions";
    }

    @PostMapping("/update")
    public String update(Profession profession) {
        professionService.update(profession);
        return "redirect:/professions";
    }

//    @PostMapping("/{id}")
//    public String updateAlt(Profession profession) {
//        professionService.update(profession);
//        return "redirect:/professions";
//    }

//    @PostMapping("/del/{id}")
//    public String delete(@PathVariable int id) {
//        professionService.delete(id);
//        return "redirect:/professions";
//    }

    @PostMapping("/del")
    public String delete(@RequestParam int id) {
        professionService.delete(id);
        return "redirect:/professions";
    }
}

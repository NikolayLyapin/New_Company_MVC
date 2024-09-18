package org.klozevitz.company_mvc_security_311.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.company_mvc_security_311.dao.DepartmentService;
import org.klozevitz.company_mvc_security_311.model.Department;
import org.klozevitz.company_mvc_security_311.model.Profession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/professions")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public String departmentsPage(Model model) {
        List<Department> all = departmentService.all();
        model.addAttribute("all", all);

        if (!model.containsAttribute("profession")) {
            // объект для привязки к форме и передачи в метод save
            Department departmentsToSave = new Department();
            model.addAttribute("profession", departmentsToSave);
        }
        return "/entities/professions";
    }

//    @PostMapping
//    public String save(@RequestParam String name, @RequestParam String note) {
//        professionService.save(new Profession(name, note));
//        return "redirect:/professions";
//    }

    @PostMapping
    public String save(Department department) {
        departmentService.save(department);
        return "redirect:/professions";
    }
}

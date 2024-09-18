package org.klozevitz.company_mvc_security_311;

import lombok.RequiredArgsConstructor;
import org.klozevitz.company_mvc_security_311.dao.DepartmentService;
import org.klozevitz.company_mvc_security_311.dao.ProfessionService;
import org.klozevitz.company_mvc_security_311.model.Department;
import org.klozevitz.company_mvc_security_311.model.Profession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/s")
@RequiredArgsConstructor
public class Utils {
    private final ProfessionService professionService;
    private final DepartmentService departmentService;

    @GetMapping
    public void dbInit() {
        professionsInit();
        departmentsInit();
    }

    private void professionsInit() {
        professionService.save(Profession.builder().name("ПМ").note("").build());
        professionService.save(Profession.builder().name("Лид").note("").build());
        professionService.save(Profession.builder().name("Разработчик").note("").build());
        professionService.save(Profession.builder().name("Тестировщик").note("").build());
        professionService.save(Profession.builder().name("Дизайнер").note("").build());
        professionService.save(Profession.builder().name("PR-менеджер").note("").build());
        professionService.save(Profession.builder().name("Специалист колл-центра").note("").build());
        professionService.save(Profession.builder().name("Маркетолог").note("").build());
        professionService.save(Profession.builder().name("Бухгалтер").note("").build());
    }

    private void departmentsInit() {
        Department root1 = departmentService.save(
                Department.builder()
                        .name("DB")
                        .note("отдел по производству DB")
                        .parentDpt(null)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        Department dev1 = departmentService.save(
                Department.builder()
                        .name("Разработка")
                        .note("родитель - 1 : DB")
                        .parentDpt(root1)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        Department dev11 = departmentService.save(
                Department.builder()
                        .name("DEV")
                        .note("родитель - 2 : Разработка")
                        .parentDpt(dev1)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        Department dev12 = departmentService.save(
                Department.builder()
                        .name("Test")
                        .note("родитель - 2 : Разработка")
                        .parentDpt(dev1)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        Department dev13 = departmentService.save(
                Department.builder()
                        .name("DESIGN")
                        .note("родитель - 2 : Разработка")
                        .parentDpt(dev1)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        Department mark1 = departmentService.save(
                Department.builder()
                        .name("Маркетинг")
                        .note("родитель - 1 : DB")
                        .parentDpt(root1)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        Department mark11 = departmentService.save(
                Department.builder()
                        .name("Колл-центр")
                        .note("родитель - 6 : Маркетинг")
                        .parentDpt(mark1)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        Department mark12 = departmentService.save(
                Department.builder()
                        .name("Медиа")
                        .note("родитель - 6 : Маркетинг")
                        .parentDpt(mark1)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        Department buh1 = departmentService.save(
                Department.builder()
                        .name("Бухгалтерия")
                        .note("родитель - 1 : DB")
                        .parentDpt(root1)
                        .subDepartments(new HashSet<>())
                        .build()
        );

        mark1.getSubDepartments().addAll(Set.of(mark11, mark12));
        departmentService.save(mark1);

        dev1.getSubDepartments().addAll(Set.of(dev11, dev12, dev13));
        departmentService.save(dev1);

        root1.getSubDepartments().addAll(Set.of(dev1, mark1, buh1));
        departmentService.save(root1);
    }
}

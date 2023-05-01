package simple.app.controller;

import simple.app.domain.Department;
import simple.app.repository.DepartmentRepository;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import simple.app.service.DepartmentService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        model.addAttribute("departments", departmentService.list());
        return "department/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("department", new Department());
        return "department/create";
    }

    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "department/create";
        }
        departmentService.create(department);
        return "redirect:/departments/list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("departmentId") Long departmentId, Model model) throws SQLException {
        model.addAttribute("department", departmentService.get(departmentId));
        return "department/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "department/edit";
        }
        departmentService.update(department);
        return "redirect:/departments/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("departmentId") Long departmentId) throws SQLException {
        departmentService.delete(departmentId);
        return "redirect:/departments/list";
    }
}

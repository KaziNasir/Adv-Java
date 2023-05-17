package simple.app.controller;

import simple.app.domain.Department;
import simple.app.domain.Employee;
import simple.app.repository.EmployeeRepository;
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
import simple.app.service.EmployeeService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class   EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        model.addAttribute("employees", employeeService.list());
        return "employee/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "employee/create";
        }
        employeeService.create(employee);
        return "redirect:/employees/list";
    }
}

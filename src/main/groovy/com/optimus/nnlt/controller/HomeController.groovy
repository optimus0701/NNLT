package com.optimus.nnlt.controller

import com.optimus.nnlt.dto.UserDTO
import com.optimus.nnlt.global.GlobalData
import com.optimus.nnlt.model.Role
import com.optimus.nnlt.model.User
import com.optimus.nnlt.service.CategoryService
import com.optimus.nnlt.service.ProductService
import com.optimus.nnlt.service.RoleService
import com.optimus.nnlt.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HomeController {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired(required = false)
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping(value = ["/", "/home", ""])
    String home(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    } //index
    @GetMapping("/users/add")
    String updateUser(Model model){
        UserDTO currentUser = new UserDTO();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails && ((UserDetails) principal).getUsername() != null) {
            String currentUsername = ((UserDetails)principal).getUsername();
            User user = userService.getUserByEmail(currentUsername).get();
            currentUser.setId(user.getId());
            currentUser.setEmail(user.getEmail());
            currentUser.setPassword("");
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            List<Integer> roleIds = new ArrayList<>();
            for (Role item:user.getRoles()) {
                roleIds.add(item.getId());
            }
            currentUser.setRoleIds(roleIds);
        }//get current User runtime

        model.addAttribute("userDTO", currentUser);
        return "userRoleAdd";
    }
    @PostMapping("/users/add")
    String postUserAdd(@ModelAttribute("userDTO") UserDTO userDTO) {
        //convert dto > entity
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        List<Role> roles = userService.getUserById(user.getId()).get().getRoles();
        user.setRoles(roles);

        userService.updateUser(user);
        return "index";
    }

    @GetMapping("/shop")
    String shop(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct());
        return "shop";
    } //view All Products

    @GetMapping("/shop/category/{id}")
    String shopByCat(@PathVariable int id, Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProductByCategoryId(id));
        return "shop";
    } //view Products By Category

    @GetMapping("/shop/viewproduct/{id}")
    String viewProduct(@PathVariable long id, Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("product", productService.getProductById(id).get());
        return "viewProduct";
    } //view product Details


}

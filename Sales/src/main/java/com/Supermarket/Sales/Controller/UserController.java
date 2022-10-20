package com.Supermarket.Sales.Controller;

import com.Supermarket.Sales.Entity.Product;
import com.Supermarket.Sales.Entity.User;
import com.Supermarket.Sales.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


        @GetMapping("/users")
        public List<User> displayUsers()
        {
            return userRepository.findAll();
        }

        //do this based on "demo" proj
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user)
    {

        user.setMemberPoints(user.calculateMemberPoints(user.getMemStartDate(),user.getMembershipStatus()));
        userRepository.save(user);

        return "User added";
    }
    @GetMapping("/userById/{userId}")
    public String userById(@PathVariable Integer userId)
    {
        //"More than one user can have the same name,it was a good call to use the user id to access data "+
       String s1= (userRepository.findById(userId)).toString();
       return "More than one user can have the same name,it was a good call to use the user id to access data"+s1;


    }
    @PutMapping("/updateUserDetails/{userId}")
    public String updateUser(@PathVariable Integer userId,@RequestBody User user)
    { User updatedUser=userRepository.findById(userId).get();
        updatedUser.setMembershipStatus(user.getMembershipStatus());
        updatedUser.setPhoneNo(user.getPhoneNo());
        userRepository.save(updatedUser);
        return "User details updated";
    }

    @DeleteMapping("/deactivateUser/{userId}")
    public String deleteUser(@PathVariable Integer userId)
    { User deactivateUser=userRepository.findById(userId).get();
        userRepository.delete(deactivateUser);
        return "Deactivate User with the id"+userId;}
    private User mapToFileResponse(User user) {
        return new User(user.getUserId(), user.getFirstName());
    }
    /*((public  User store(MultipartFile userPhoto) throws IOException {
        String fileName = userPhoto.getOriginalFilename();
        User latestPhoto = new User(UUID.randomUUID().toString(), fileName, userPhoto.getContentType(), userPhoto.getBytes());
        userRepository.save(latestPhoto);
        return  mapToFileResponse(latestPhoto);
    }*/
 /*   @PostMapping("User/uploadPhoto")
    public User uploadPhoto(@RequestParam("userPhoto") MultipartFile userPhoto) throws IOException {
        String fileName = userPhoto.getOriginalFilename();
        User latestPhoto = new User(UUID.randomUUID().toString(), fileName, userPhoto.getContentType(), userPhoto.getBytes());
       return userRepository.save(latestPhoto);

    }

    @GetMapping("/{userId}")
    public User getFile(@PathVariable Integer userId) {
        Optional<User> userWithPhoto = userRepository.findById(userId);
return  userWithPhoto.get();
    }*/
    //String s1 = help.toString();
   // String s2 = String.valueOf(help);
    /*  private final StorageService storageService;

    @Autowired
    public PhotoUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/uploadPhoto")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(PhotoUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
*/


}

package shopping.service;

import shopping.model.service.UserServiceModel;

public interface UserService {
    //register user
    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}

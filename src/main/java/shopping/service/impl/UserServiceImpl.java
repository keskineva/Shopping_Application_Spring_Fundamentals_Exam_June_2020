package shopping.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import shopping.model.entity.User;
import shopping.model.service.UserServiceModel;
import shopping.repository.UserRepository;
import shopping.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        //UserServiceModel->User
        User user = this.modelMapper
                .map(userServiceModel, User.class);

        //save the user to the repository and return the userServiceModel

        return this.modelMapper
                .map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}

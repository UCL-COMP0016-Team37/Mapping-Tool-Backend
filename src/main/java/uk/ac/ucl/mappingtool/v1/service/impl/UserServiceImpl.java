package uk.ac.ucl.mappingtool.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.v1.domain.User;
import uk.ac.ucl.mappingtool.v1.repository.UserRepository;
import uk.ac.ucl.mappingtool.v1.service.UserService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Delete some user by id
     * @param id
     */
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    /**
     * Add new user
     * @param user
     */
    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    /**
     * update some user by id
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        userRepository.save(user);
        return 1;
    }

    /**
     * get info of a single user by id
     * @param id
     * @return
     */
    @Override
    public User selectById(int id) {
        Optional<User> optional = userRepository.findById(id);
        User user = optional.get();
        return user;
    }

    /**
     * get all user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Iterator<User> selectAll(int pageNum, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<User> users = userRepository.findAll(pageable);
        Iterator<User> userIterator =  users.iterator();
        return  userIterator;
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User getByName(String userName) {
        return userRepository.findUser(userName);
    }
}

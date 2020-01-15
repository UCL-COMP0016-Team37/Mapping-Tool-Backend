package uk.ac.ucl.mappingtool.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.v1.domain.UserV1;
import uk.ac.ucl.mappingtool.v1.repository.UserRepositoryV1;
import uk.ac.ucl.mappingtool.v1.service.UserServiceV1;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceV1ImplV1 implements UserServiceV1 {
    @Autowired
    private UserRepositoryV1 userRepositoryV1;

    /**
     * Delete some user by id
     * @param id
     */
    @Override
    public void delete(int id) {
        userRepositoryV1.deleteById(id);
    }

    /**
     * Add new userV1
     * @param userV1
     */
    @Override
    public void insert(UserV1 userV1) {
        userRepositoryV1.save(userV1);
    }

    /**
     * update some userV1 by id
     * @param userV1
     * @return
     */
    @Override
    public int update(UserV1 userV1) {
        userRepositoryV1.save(userV1);
        return 1;
    }

    /**
     * get info of a single user by id
     * @param id
     * @return
     */
    @Override
    public UserV1 selectById(int id) {
        Optional<UserV1> optional = userRepositoryV1.findById(id);
        UserV1 userV1 = optional.get();
        return userV1;
    }

    /**
     * get all user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Iterator<UserV1> selectAll(int pageNum, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<UserV1> users = userRepositoryV1.findAll(pageable);
        Iterator<UserV1> userIterator =  users.iterator();
        return  userIterator;
    }

    @Override
    public List<UserV1> getAll(){
        return userRepositoryV1.findAll();
    }
}

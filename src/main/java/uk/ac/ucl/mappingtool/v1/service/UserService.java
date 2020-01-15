package uk.ac.ucl.mappingtool.v1.service;

import uk.ac.ucl.mappingtool.v1.domain.User;

import java.util.Iterator;
import java.util.List;

public interface UserService {

    public void delete(int id);
    public void insert(User user);
    public int update(User user);
    public User selectById(int id);
    public Iterator<User> selectAll(int pageNum, int pageSize);
    public List<User> getAll();
}

package uk.ac.ucl.mappingtool.v1.service;

import uk.ac.ucl.mappingtool.v1.domain.UserV1;

import java.util.Iterator;
import java.util.List;

public interface UserServiceV1 {

    public void delete(int id);
    public void insert(UserV1 userV1);
    public int update(UserV1 userV1);
    public UserV1 selectById(int id);
    public Iterator<UserV1> selectAll(int pageNum, int pageSize);
    public List<UserV1> getAll();
}

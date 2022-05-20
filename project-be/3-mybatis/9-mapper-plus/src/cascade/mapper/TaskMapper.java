package cascade.mapper;

import cascade.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {

    int getTaskCount();

    Task getTaskById(Long id);

    List<Task> getTasks(@Param("offset") Long pageNo, @Param("limit") Long limit);

    int addTask(Task task);

    int deleteTask(Long id);

    int updateTask(Task task);

}

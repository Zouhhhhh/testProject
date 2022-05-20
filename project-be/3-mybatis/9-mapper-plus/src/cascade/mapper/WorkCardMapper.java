package cascade.mapper;

import cascade.pojo.WorkCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkCardMapper {

//    int getWorkCardCount();

    WorkCard getWorkCardByEmpId(Long empId);

//    List<WorkCard> getWorkCards(@Param("offset") Long pageNo, @Param("limit") Long limit);

//    int addWorkCard(WorkCard workCard);

//    int deleteWorkCard(Long id);

//    int updateWorkCard(WorkCard workCard);


}

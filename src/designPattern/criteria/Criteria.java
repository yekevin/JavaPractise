package designPattern.criteria;

import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public interface Criteria {

    public List<Person> meetCriteria(List<Person> persons);

}

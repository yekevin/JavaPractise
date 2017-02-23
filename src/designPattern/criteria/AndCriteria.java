package designPattern.criteria;

import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPerson= criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPerson);
    }
}

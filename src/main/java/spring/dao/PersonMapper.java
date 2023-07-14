//package spring.dao;
//
//import org.springframework.jdbc.core.RowMapper;
//import spring.models.Person;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class PersonMapper implements RowMapper<Person> {
//    @Override
//    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
//        Person person = new Person();
//
//        person.setId(resultSet.getInt("id"));
//        person.setName(resultSet.getString("name"));
//        person.setEmail(resultSet.getString("email"));
//        person.setAge(resultSet.getInt("age"));
//
//        return person;
//    }
//}
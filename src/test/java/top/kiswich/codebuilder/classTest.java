package top.kiswich.codebuilder;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import top.kiswich.codebuilder.pojo.base.webFormat.TableMapping;
import top.kiswich.codebuilder.pojo.base.webFormat.in.*;

public class classTest {
    @Test
    public void testClass(){
        TableMapping mapping = new TableMapping();
        ManyToMany manyToMany = new ManyToMany();
        manyToMany.setTable1(new TableNormal(1,5));
        manyToMany.setTable2(new TableNormal(2,5));
        manyToMany.setTableMid(new TableMid(5,new TableNormal(1,1),new TableNormal(2,2)));
        mapping.getManyToManies().add(manyToMany);

        OneToMany oneToMany = new OneToMany();
        oneToMany.setOneTable(new TableNormal(10,5));
        oneToMany.setManyTable(new TableNormal(9,2));
        mapping.getOneToManies().add(oneToMany);

        OneToOne oneToOne = new OneToOne();
        oneToOne.setHoldTable(new TableNormal(7,6));
        oneToOne.setTable(new TableNormal(5,4));
        mapping.getOneToOnes().add(oneToOne);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(mapping);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}

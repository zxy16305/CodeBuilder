package top.kiswich.codebuilder.pojo.base;

/**
 * 前端传过来的表结构的映射关系字段
 * 在实体映射中需要4中，但是 OneToMany和ManyToOne是一样的
 * 因此传三种回来就可以了
 *
 * 其中双向多对多映射，要创建中间类 emmmmm,好复杂
 * eg.
 * {@code
 *
 *      {
 *          "OneToOne":[
 *              {
 *                  tableId1:n1,
 *                  tableId2:n2,
 *                  column:{
 *                      tableId:n1(n2),
 *                      columnId:n3
 *                  }
 *              },...
 *          ],
 *          "OneToMany":[
 *              {
 *                  tableId1:n1,
 *                  tableId:n2,
 *                  column:{
 *                      tableId:n1(n2),
 *                      columnId:n3
 *                  }
 *              },...
 *          ],
 *          "ManyToMany":[
 *              {
 *                  tableId1:n1,
 *                  tableId2:n2,
 *
 *              },...
 *          ]
 *      }
 */
public class TableMapping {
}

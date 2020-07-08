# zybook-tester
Simple JUNIT "like" wrapper for Zylabs Unit Testing. Provides feedback for students
in a standard format, so all tests will utilize that feedback. The goal
is that you will develop tests locally using JUNIT, and then should
be able to copy those tests to zylabs with only minimal modifications to 
work in the Zylabs environment. 

## Usage 

Include in **Additional files** in zylabs. You can then use it unit tests. For example

```java
public class zyLabsUnitTest {
    public boolean passed(PrintWriter testFeedback) {
      ZybooksTester tester = new ZybooksTester(testFeedback);
      MOB mob = new MOB("Test", 15, 10, -1, DiceType.D4);
      boolean test1 =  tester.assertEquals(0, mob.getDamage(), "Get Damage");
      mob.addDamage(5);
      boolean test2 = tester.assertEquals(5 ,mob.getDamage(), "Add Damage");
      boolean test3 = tester.assertEquals(10, mob.getHP(), "Get HP");
      mob.resetDamage();
      boolean test4 = tester.assertEquals(15, mob.getHP(), "Get HP after resetDamage()");
      return test1 && test2 && test3 && test4;
      
    }
}
```
or
```java
public class zyLabsUnitTest {
    public boolean passed(PrintWriter testFeedback) {
      ZybooksTester tester = new ZybooksTester(testFeedback);
      Knight knight = new Knight(1, "Merlin", 50, 2,  1, DiceType.D12, 0);
      String expected = "+============================+\n" +
                "| Merlin                     |\n" +
                "| id: 1                      |\n" +
                "|                            |\n" +
                "| Health: 50      XP: 0      |\n" +
                "|  Power: D12     Armor: 2   |\n" +
                "|                            |\n" +
                "+============================+";
      String csv = "Merlin,50,2,1,D12,0";
            
      return tester.assertEquals(expected,knight.toString().trim()) &&
             tester.assertEquals(csv, knight.toCSV().trim());
      
      
    }
}
```
## Contributing

Bug reports and pull requests are welcome on GitHub at 
https://github.com/Dept-of-Computer-Science/zybook-tester. 
This project is intended to be a safe, welcoming space for collaboration, and contributors are expected 
to adhere to the [Contributor Covenant](http://contributor-covenant.org) code of conduct.


## License

The theme is available as open source under the terms of the [MIT License](https://opensource.org/licenses/MIT).




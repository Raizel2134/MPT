import lab1.XPathTask;

public class Runner {
    public static void main(String[] args) {
        new XPathTask().readXPathExpression("example.xml","//studio/group[date='24/11/2021'][studioName='First studio']", "output.xml");
    }
}

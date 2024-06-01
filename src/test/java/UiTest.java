import org.junit.jupiter.api.Test;

public class UiTest {
    @Test(testName = "VerifyIfUserHasCanceledInvoice")
    public void VerifyIfUserHasCanceledInvoice() {
        String fn = "John";
        String ln = "Doe";
        String lg = "j.doe@test.com";
        String pw = "qwerty123";

        System.out.println("Step 1: Login");
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(lg, pw);

        System.out.println("Step 2: Open invoices page");
        InvoicesPage ip = new InvoicesPage();
        List<String> ci = ip.getAll().stream()
                .filter(i -> i.split(" ")[0].contains("Canceled"))
                .map(ci -> ci.split(" ")[1])
                .collect(Collectors.toList());

        System.out.println("Step 3: Get invoices from backend");
        InvoicesRequester ir = new InvoicesRequester();
        ir.login(lg, pw);
        List<JSONObject> bi = ir.ListOfInvoices()
                .map(i -> new JSONObject(i))
                .collect(Collectors.toList());
        List<String> bif;
        if (bi.size() != 0) {
            bif = bi.filter(pi -> pi.getJsonObject("status").cointains("Canceled"))
                    .map(inv -> inv.getJsonObject("number"))
                    .collect(Collectors.toList());
        } else
            System.out.println("Invoices list is empty");
        Assert.assertTrue(bif == ci);
    }
}

package FILES;

/**
 *
 * @author alefdelgado
 */
public class account
{
    String user;
    String password;
    int accountnum;
    int saldo;

    public account(String name, String password, int accountnum, int saldo)
    {
        this.user = name;
        this.password = password;
        this.accountnum = accountnum;
        this.saldo = saldo;
    }

    public String getName()
    {
        return user;
    }

    public void setName(String name)
    {
        this.user = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getAccountnum()
    {
        return accountnum;
    }

    public void setAccountnum(int accountnum)
    {
        this.accountnum = accountnum;
    }

    public int getSaldo()
    {
        return saldo;
    }

    public void setSaldo(int saldo)
    {
        this.saldo = saldo;
    }

    @Override
    public String toString()
    {
        return "Usuario{" + "name=" + user + ", password=" + password + ", accountnum=" + accountnum + ", saldo=" + saldo + '}';
    }
    
    
}

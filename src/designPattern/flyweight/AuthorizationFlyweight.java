package designPattern.flyweight;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class AuthorizationFlyweight implements Flyweight {

    private String securityEntry;
    private String permit;

    public String getSecurityEntry() {
        return securityEntry;
    }

    public String getPermit() {
        return permit;
    }

    public AuthorizationFlyweight(String state) {
        String[] entry = state.split(",");
        this.securityEntry = entry[0];
        this.permit = entry[1];
    }

    @Override
    public boolean match(String securityEntry, String permit) {
        return this.securityEntry.equals(securityEntry) && this.permit.equals(permit);
    }
}

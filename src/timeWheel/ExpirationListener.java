package timeWheel;

/**
 * @author Kevin
 * @description
 * @date 2017/3/16
 */
public interface ExpirationListener<E> {

    void expired(E expiredObject);
}

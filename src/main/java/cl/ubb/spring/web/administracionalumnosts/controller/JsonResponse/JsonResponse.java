package cl.ubb.spring.web.administracionalumnosts.controller.JsonResponse;

/**
 * Created by w7600PC on 06/07/2014.
 */
public class JsonResponse {
    private String status = null;

    private Object result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

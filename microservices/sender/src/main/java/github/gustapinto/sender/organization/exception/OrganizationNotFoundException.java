package github.gustapinto.sender.organization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Organization not found")
public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException() {
        super(String.format("Organization not found"));
    }

    public static OrganizationNotFoundException make() {
        return new OrganizationNotFoundException();
    }
}

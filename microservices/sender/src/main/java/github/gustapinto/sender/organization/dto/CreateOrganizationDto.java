package github.gustapinto.sender.organization.dto;

import ch.qos.logback.core.util.StringUtil;

public class CreateOrganizationDto {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void validate() throws IllegalArgumentException {
        if (StringUtil.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }

        if (StringUtil.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
    }
}

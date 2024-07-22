package github.gustapinto.sender.organization.dto;

import ch.qos.logback.core.util.StringUtil;

public class UpdateOrganizationDto {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void validate() throws IllegalArgumentException {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("id cannot be null or zero");
        }

        if (StringUtil.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
    }
}

package estate.entity.database;

/**
 * Created by kangbiao on 15-9-21.
 */
public class SsidSecretEntity
{
    private Integer id;
    private Integer buildingId;
    private String ssid;
    private String secret;
    private String buildingCode;

    public Integer getBuildingId()
    {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId)
    {
        this.buildingId = buildingId;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getSecret()
    {
        return secret;
    }

    public void setSecret(String secret)
    {
        this.secret = secret;
    }

    public String getSsid()
    {
        return ssid;
    }

    public void setSsid(String ssid)
    {
        this.ssid = ssid;
    }

    public String getBuildingCode()
    {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode)
    {
        this.buildingCode = buildingCode;
    }
}

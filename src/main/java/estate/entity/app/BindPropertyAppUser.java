package estate.entity.app;

import estate.entity.database.AppUserEntity;
import estate.entity.database.PropertyEntity;

import java.util.ArrayList;

/**
 * Created by kangbiao on 15-10-21.
 * 
 */
public class BindPropertyAppUser
{
    private PropertyEntity propertyEntity;
    private ArrayList<AppUserEntity> appUserEntities;


    public PropertyEntity getPropertyEntity()
    {
        return propertyEntity;
    }

    public void setPropertyEntity(PropertyEntity propertyEntity)
    {
        this.propertyEntity = propertyEntity;
    }

    public ArrayList<AppUserEntity> getAppUserEntities()
    {
        return appUserEntities;
    }

    public void setAppUserEntities(ArrayList<AppUserEntity> appUserEntities)
    {
        this.appUserEntities = appUserEntities;
    }
}

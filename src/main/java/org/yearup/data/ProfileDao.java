package org.yearup.data;


import org.yearup.models.Product;
import org.yearup.models.Profile;

public interface ProfileDao
{
    Product getById(int categoryId);

    Profile create(Profile profile);
}

/*
 * Copyright © 2003 - 2024 The eFaps Team (-)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.efaps.esjp.loyalty.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.efaps.admin.program.esjp.EFapsApplication;
import org.efaps.admin.program.esjp.EFapsUUID;
import org.efaps.db.Instance;

@EFapsUUID("68751580-97f5-450b-932a-d569ba1c9617")
@EFapsApplication("eFapsApp-Loyalty")
public class PointsBalance
{

    private Instance contactInst;

    private Integer points;

    private BigDecimal equivalentAmount;

    private String equivalentCurrency;

    private Map<String, Object> extend;

    public Map<String, Object> getExtend()
    {
        return extend;
    }

    public PointsBalance setExtend(Map<String, Object> extend)
    {
        this.extend = extend;
        return this;
    }

    public PointsBalance addExtend(final String key,
                                   final Object value)
    {
        if (this.extend == null) {
            this.extend = new HashMap<>();
        }
        this.extend.put(key, value);
        return this;
    }

    public BigDecimal getEquivalentAmount()
    {
        return equivalentAmount;
    }

    public PointsBalance setEquivalentAmount(BigDecimal equivalentAmount)
    {
        this.equivalentAmount = equivalentAmount;
        return this;
    }

    public String getEquivalentCurrency()
    {
        return equivalentCurrency;
    }

    public PointsBalance setEquivalentCurrency(String equivalentCurrency)
    {
        this.equivalentCurrency = equivalentCurrency;
        return this;
    }

    public PointsBalance setPoints(Integer points)
    {
        this.points = points;
        return this;
    }

    public Integer getPoints()
    {
        return points;
    }

    public Instance getContactInst()
    {
        return contactInst;
    }

    public PointsBalance setContactInst(Instance contactInst)
    {
        this.contactInst = contactInst;
        return this;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}

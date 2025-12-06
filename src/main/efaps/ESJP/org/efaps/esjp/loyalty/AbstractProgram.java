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
package org.efaps.esjp.loyalty;

import org.efaps.admin.program.esjp.EFapsApplication;
import org.efaps.admin.program.esjp.EFapsUUID;
import org.efaps.ci.CIType;
import org.efaps.db.Instance;
import org.efaps.eql.EQL;
import org.efaps.esjp.ci.CILoyalty;
import org.efaps.util.EFapsException;

@EFapsUUID("b5ab7757-31cd-4014-ad91-21c05d4923d2")
@EFapsApplication("eFapsApp-Loyalty")
public abstract class AbstractProgram
{

    public Instance evalProgramInstance4Contact(final Instance contactInstance, final String identifier)
        throws EFapsException
    {
        Instance ret = null;
        final var eval = EQL.builder().print().query(getCIType())
                        .where()
                        .attribute(CILoyalty.ProgramAbstract.ContactLink).eq(contactInstance)
                        .select()
                        .attribute(CILoyalty.PaymentAbstract.ID)
                        .evaluate();
        if (eval.next()) {
            ret = eval.inst();
        }
        if (ret == null && autoCreate()) {
            ret = EQL.builder().insert(getCIType())
                            .set(CILoyalty.ProgramAbstract.ContactLink, contactInstance)
                            .set(CILoyalty.ProgramAbstract.Identifier, identifier)
                            .set(CILoyalty.ProgramAbstract.StatusAbstract, CILoyalty.ProgramStatus.Active)
                            .execute();
        }
        return ret;
    }

    protected boolean autoCreate()
        throws EFapsException
    {
        return false;
    }

    protected abstract CIType getCIType()
        throws EFapsException;
}

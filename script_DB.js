/**
 * Скрипт формирующий роль для читателя базы знаний
 */
//Версия: 4.2.0.2
//Категория: Права. Вычислимые роли.

//ПАРАМЕТРЫ------------------------------------------------------------
def ACCESS = 'accessKB$2377606' // UUID объекта "Доступ к БЗ"


//ОСНОВНОЙ БЛОК--------------------------------------------------------


if (user.parent.agreementNda = true)
{
        return true;
}

if (!user.agreementNda)
{
    return false;
}
else
{
    for (contract in user.agreementNda)
    {
        if (contract.state == 'active' && contract.kbAccess.UUID.contains(ACCESS))
        {
            return true;
        }    
    }
}
return false;


// ===================================================================================

/**
 * Скрипт формирующий роль для читателя базы знаний
 */
//Версия: 4.2.0.2
//Категория: Права. Вычислимые роли.

//ПАРАМЕТРЫ------------------------------------------------------------
def ACCESS = 'accessKB$2377606' // UUID объекта "Доступ к БЗ"

//ОСНОВНОЙ БЛОК--------------------------------------------------------
if (user.metaClass.getCase() == 'naumen' || user.metaClass.getCase() == 'agreementNda')
{
        return true;
}

if (!ou.agreementNda)
{
    return false;
}
else
{
    for (contract in ou.agreementNda)
    {
        if (contract.state == 'active' && contract.kbAccess.UUID.contains(ACCESS))
        {
            return true;
        }    
    }
}
return false;

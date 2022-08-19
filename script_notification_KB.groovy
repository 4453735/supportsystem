def noIncludeSubscribe  = utils.find('ou$company', ['cancelSubscrib':'false']);


logger.info(noIncludeSubscribe);



if (noIncludeSubscribe == false) {
      notification.to.remove(user.email)
    notification.toEmployee.remove(user)
}

logger.info(noIncludeSubscribe);






// if (user.parent.agreementNda == true){        return true;}


def noIncludeSubscribe  = utils.find('ou$company', ['testCheckBox':'true']);
logger.info("${noIncludeSubscribe.employees.email}");

for(int i = 0;i < noIncludeSubscribe.employees.email.size(); i++) {
         for(int y = 0; y < noIncludeSubscribe.employees.email[i].size(); y++){
            // notification.to[email] = noIncludeSubscribe.employees.email[i][y];
            notification.toEmployee << noIncludeSubscribe.employees[i][y];
            // logger.info(noIncludeSubscribe.employees.email[i][y]);
         }
      }

noIncludeSubscribe.each{companyArr->
    company.each{employersArr->
        notification.toEmployee << employersArr
    }
}


// Добавление в получатели оповещения сотрудников компании, отмеченных checkbox
def noIncludeSubscribe  = utils.find('ou$company', ['testCheckBox':'true']);
notification.to[email] = noIncludeSubscribe.employees.email
notification.scriptParams['author'] = (subject.author) ? subject.author.title : 'Суперпользователь'

// Исключает автора действий из получателей оповещения.
if(null != user) {
  notification.to.remove(user.email)
  notification.toEmployee.remove(user)
}

// Подпись к оповещению контактного лица по email
notification.scriptParams['emailSignature'] = utils.get('root', [:]).emailSignature ?: ''     


//

def noIncludeSubscribe  = utils.find('ou$company', ['testCheckBox':'true']);

for(int i = 0;i < noIncludeSubscribe.employees.email.size(); i++) {
         for(int y = 0; y < noIncludeSubscribe.employees.email[i].size(); y++){
            logger.info(noIncludeSubscribe.employees.email[i][y]);
         }
      }
noIncludeSubscribe.each{company->
    company.each{employers->
        notification.toEmployee << employers
    }
}
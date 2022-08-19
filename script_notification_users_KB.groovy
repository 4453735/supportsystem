// Добавление в получатели оповещения сотрудников компании, отмеченных checkbox
def noIncludeSubscribe  = utils.find('ou$company', ['testCheckBox':'true']);
for(int i = 0;i < noIncludeSubscribe.employees.size(); i++) {
         for(int y = 0; y < noIncludeSubscribe.employees[i].size(); y++){
            notification.toEmployee << noIncludeSubscribe.employees[i][y];
            // logger.info(noIncludeSubscribe.employees.email[i][y]);
         }
      }

notification.scriptParams['author'] = (subject.author) ? subject.author.title : 'Суперпользователь'

// Исключает автора действий из получателей оповещения.
if(null != user) {
  notification.to.remove(user.email)
  notification.toEmployee.remove(user)
}

// Подпись к оповещению контактного лица по email
notification.scriptParams['emailSignature'] = utils.get('root', [:]).emailSignature ?: ''   
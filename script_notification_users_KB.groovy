// Добавление в получатели оповещения сотрудников компании, отмеченных checkbox
def noIncludeSubscribe  = utils.find('ou$company', ['cancelSubscrib':'false']);
noIncludeSubscribe = noIncludeSubscribe.employees
noIncludeSubscribe.each({def company->
    company.each({def employers->
      notification.toEmployee << employers;
    })
})


notification.scriptParams['author'] = (subject.author) ? subject.author.title : 'Суперпользователь'

// Исключает автора действий из получателей оповещения.
if(null != user) {
  notification.to.remove(user.email)
  notification.toEmployee.remove(user)
}

// Подпись к оповещению контактного лица по email
notification.scriptParams['emailSignature'] = utils.get('root', [:]).emailSignature ?: ''   
# Test Automation Project for [ТПММГ](https://s77wbtom001pr01.mg-tpm.rt.ru)

## **Contents:** ##

* <a href="#tools">Используемые технологии/ Коротко о проекте</a>

* <a href="#cases">Пример тестов</a>

* <a href="#jenkins">Build в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure report</a>

* <a href="#jira">Интеграция с Jira</a>




-----
<a id="tools"></a>
## <a name="Используемые технологии/ Коротко о проекте">**Используемые технологии/ Коротко о проекте:**</a>

<p align="center">
<a href="https://www.w3schools.com/java/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/> </a> 
<a href="https://www.jetbrains.com/idea/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" title="IntelliJ Idea" alt="IntelliJ Idea" width="40" height="40"/> </a> 
<a href="https://git-scm.com/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/git/git-original.svg" title="Git" alt="Git" width="40" height="40"/> </a> 
<a href="https://gradle.org"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" title="Gradle" alt="Gradle" width="40" height="40"/> </a>
<a href="https://www.jenkins.io"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" title="Jenkins" alt="Jenkins" width="40" height="40"/> </a>
<a href="https://www.atlassian.com/software/jira"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original.svg" title="Jira" alt="Jira" width="40" height="40"/> </a>
</p>

- Разрабатывал автотесты **Java** для проекта, на котором раннее работал ручным тестировщиком. Web разработан на Flutter, на который нету возможности сделать UI тесты, поэтому всё сделано на API слое. В моём проекте я соединил несколько тестов в один, запускаются они последовательно. Результатом этих тестов является сформированный документ (Коммерческий план маршрутизации).



----
<a id="cases"></a>
## **Пример тестов:**
**Ручные тесты **
- ✅ Авторизация на сайте
- ✅ Создание нового докумета
- ✅ Выбор типа Маршрутизации и контрольной даты
- ✅ Выбор группы операторов в качестве Источника


**Автоматизированные тесты**
- ✅ Аутенфикация и Авторизация
- ✅ Проверка возможности создания нового КПМ от текущего пользователя
- ✅ Выбор типа Маршрутизации
- ✅ Сохранение группы операторов "Национальные" в качестве источника
- ✅ Выбор оператора и города в разделе "Направление"


----
<a id="jenkins"></a>
## Build в Jenkins ([Ссылка](https://jenkins.autotests.cloud/job/Zhukov%20diploma/))
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/egorovaa_uitests_17/"><img src="images/screen/jenkins_report.png" alt="Jenkins" width="950"/></a>  
</p>

----
<a id="console"></a>
## Запуск из терминала
**Локальный запуск**
```bash  
gradle simple_test
```

**Remote launch via Jenkins**
```bash
simple_test
```


----
<a id="allure"></a>
## Allure report ([link](https://jenkins.autotests.cloud/job/egorovaa_uitests_17/allure/))

**Main report page**
<p align="center">  
<a href="https://ihelp.rt.ru/secure/Tests.jspa#/testCase/TPMMG-T58"><img src="src/test/resoursec/allure.png" alt="Jira" width="950"/></a> 
</p>


----
<a id="jira"></a>
## Интеграция с Jira ([Ссылка](https://ihelp.rt.ru/secure/Tests.jspa#/testCase/TPMMG-T58))
<p align="center">  
<a href="https://ihelp.rt.ru/secure/Tests.jspa#/testCase/TPMMG-T58"><img src="src/test/resoursec/jira.png" alt="Jira" width="950"/></a>  
</p>





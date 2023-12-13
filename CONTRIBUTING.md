### Epics, User stories och tasks

DoD - Definition of done

En Epic är “done” när dess user stories är “done”

En User story är “done” när alla user storyns tasks är avklarade.

Ett task är “done” när den uppfyller sina specifika acceptance criteria. 

#### Tasks Skall följa SMART

Specific <br>
Measurable <br>
Achievable <br>
Relevant <br>
Time bound <br>

#### User stories skall följa INVEST

Independent (from other US, should be possible to implement in any order) <br>
Negotiable (Invitation to a conversation, can be changed, redacted) <br>
Valuable <br>
Small <br>
Testable (There must be a way to test if the story is done) <br>


### Konventioner som skall följas
* Skriv kommentarer, variabel, klass, directory namn på Engelska och i camelcase (ex: public void setSailSouthWards() {} ). Annan text på Github skall också vara på engelska. Packages skall skrivas i lowercase.
* Kommentarer i kod skall skrivas enligt Javadoc, alla klasser och metoder skall kommenteras. 
* README dokumentation skall skrivas på med task id + task titel och punkterna datum för task completion, vem som avklarade tasken, vad, hur, varför, user interaction(hur features används av spelaren).

### Testning
Alla klasser skall ha en testklass, alla publika metoder i klassen skall ha ett test. Om något ej går att testa ha med testet ändå och skriva dokumentation om varför det inte går att testa. Abstrakta klasser skall testas med privata inre klasser i testklassen.

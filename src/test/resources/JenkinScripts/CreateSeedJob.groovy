job('RunAdidasTest_Temp') {
  description "Gets Adidas code from master branch and executes maven commands."
    scm {
        git('https://github.com/kraviraju/Adidas_POM_Selenium.git')
    }
    steps {
        maven('-e clean test')
    }
}
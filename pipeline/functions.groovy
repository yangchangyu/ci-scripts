def clone2local(giturl, localdir) {
    def exists = fileExists localdir
    if (!exists){
        new File(localdir).mkdir()
    }
    dir (localdir) {
        git url: giturl
    }
}

def send_mail() {
    //get mail info
    mailTo = readFile 'MAIL_LIST.txt'
    mailSubject = readFile 'MAIL_SUBJECT.txt'
    mailContent = readFile 'MAIL_CONTENT.txt'
    // send test result
    mail bcc: '', body: mailContent, cc: '', from: 'qinsl0106@thundersoft.com', replyTo: 'qinsl0106@thundersoft.com', subject: mailSubject, to: mailTo
}

return this

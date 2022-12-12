package com.optimus.nnlt

class Test {
    static void main(String[] args) {
        def password = "myPassword"

        def md5 = password.md5()
        def sha256 = password.sha256()
        //For other algorithms use digest() method
        def sha1 = password.digest('SHA-1')
    }
}

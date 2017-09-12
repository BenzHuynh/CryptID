//
//  ViewController.swift
//  Password
//
//  Created by Benz Huynh on 5/1/17.
//  Copyright © 2017 Benz Huynh. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate
{
    
    //MARK: Properties
    @IBOutlet weak var input: UITextField!
    @IBOutlet weak var createdPW: UILabel!
    @IBOutlet weak var pwText: UITextView!
    @IBOutlet weak var entBtn: UIButton!
    
    
    override func viewDidLoad()
    {
        super.viewDidLoad()
        
        self.input.delegate = self
    }

    override func didReceiveMemoryWarning()
    {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    //MARK: Actions
    func textFieldShouldReturn(_ textField: UITextField) -> Bool
    {
        self.view.endEditing(true)
        enterBtn(entBtn)
        return true
    }
    
    
    @IBAction func enterBtn(_ sender: UIButton)
    {
        pwText.textColor = UIColor.blue
        var user: String = input.text!
        let userArr = Array(user.characters)
        let size = user.characters.count - 1;
        var password = ""
        
        if user == ""
        {
            pwText.textColor = UIColor.red
            pwText.text = "INVALID INPUT"
            
            return
        }
        //part 1: get all even characters, then all odd characters
        //"even characters" + "odd characters"
        for x in 0...size
        {
            if x % 2 == 0
            {
                if x == 0
                {
                    password += String(userArr[x]).uppercased()
                }
                else
                {
                    password += String(userArr[x])
                }
                
            }
            
        }
        for x in 0...size
        {
            if x % 2 != 0
            {
                password += String(userArr[x])
            }
        }
        
        //part 2: create the special character
        //Special character ASCII value = "number of letters" + "number of numbers"
        var ltr = 0
        var num = 0
        let numList = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
        for x in 0...size
        {
            let temp = String(userArr[x])
            if numList.contains(temp)
            {
                num += 1
            }
            else
            {
                ltr += 1
            }
            
        }
        var specNum: Int = Int("\(ltr)\(num)")!
        var specChar = UnicodeScalar(specNum)!.escaped(asASCII: true)
        let specList = [" ", "!", "\"", "#", "$", "%", "&", "\'", "(", ")", "*", "+",
                         ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[",
                         "\\", "]", "^", "_", "`", "{", "|", "}", "~"]
        
        while specList.contains(specChar) == false
        {
            if specNum > 31
            {
                specNum -= 1
            }
            else
            {
                specNum = 127
            }
            specChar = UnicodeScalar(specNum)!.escaped(asASCII: true)
        }
        password += specChar
        
        //part 3: final numbers at the end
        //"number of even letters" + "number of odd letters" + "number of numbers"
        var numEven = 0
        var numOdd = 0
        var numNum = 0
        for x in 0...size
        {
            let temp = String(userArr[x])
            if numList.contains(temp)
            {
                numNum  += 1
            }
            else
            {
                if x % 2 == 0
                {
                    numEven += 1
                }
                else
                {
                    numOdd += 1
                }
                
                
            }
        }
        password += "\(numEven)\(numOdd)\(numNum)"
        
        pwText.text = password
    }
    
}


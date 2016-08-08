
package com.mygdx.game;

import com.mygdx.game.staticEntities.blackWall;
import com.mygdx.game.staticEntities.*;
//TO  ADD NEW STATIC ENTITY
//1) CREATE STATIC ENTITY CLASS IN .STATICENTITIES
//2) UPDATE GETSTATICENTITY IN MAP.JAVA
public abstract class StaticEntity extends GroundEntity{
    public boolean solid = true;
    
    //general use 'interact' method to be overridden
    //by staticentities which inherit from this class.
    //method general represents what happens when
    //the player approaches the entity and 'interacts' with it
    public void interact(){
        return;
    }
    
    public static StaticEntity getStaticEntity(String inStr){
        char p1 = inStr.charAt(0);
        char p2 = inStr.charAt(1);
        char p3 = inStr.charAt(2);
        if(p1=='#'){
        	if(p2=='w'){
        		if(p3=='l'){
        			return new blackWall();
        		}
        	}
        }
        if(p1=='b'){
        	if(p2=='b'){
        		if(p3=='1'){
        			return new billBoard(1);
        		}
        		if(p3=='2'){
        			return new billBoard(2);
        		}
        	}
        	if(p2=='d'){
        		if(p3=='1'){
        			return new bldgDecal(1);
        		}
        		if(p3=='2'){
        			return new bldgDecal(2);
        		}
        		if(p3=='3'){
        			return new bldgDecal(3);
        		}
        		if(p3=='4'){
        			return new bldgDecal(4);
        		}
        		if(p3=='5'){
        			return new bldgDecal(5);
        		}
        		if(p3=='6'){
        			return new bldgDecal(6);
        		}
        		if(p3=='7'){
        			return new bldgDecal(7);
        		}
        		if(p3=='8'){
        			return new bldgDecal(8);
        		}
        		if(p3=='9'){
        			return new bldgDecal(9);
        		}
        		
        	}
        }
        if(p1=='c'){
        	if(p2=='r'){
        		if(p3=='1'){
        			return new carA();
        		}
        	}
        	if(p2=='w'){
        		if(p3=='l'){
        			return new caveWall();
        		}
        	}
        }
        if(p1=='f'){
        	if(p2=='n'){
        		if(p3=='1'){
        			return new fence(1);
        		}
        		if(p3=='2'){
        			return new fence(2);
        		}
        		if(p3=='3'){
        			return new fence(3);
        		}
        		if(p3=='4'){
        			return new fence(4);
        		}
        		if(p3=='5'){
        			return new fence(5);
        		}
        		if(p3=='6'){
        			return new fence(6);
        		}
        		if(p3=='7'){
        			return new fence(7);
        		}
        		if(p3=='8'){
        			return new fence(8);
        		}
        	}
        	if(p2=='t'){
        		if(p3=='0'){
        			return new bldgFooter(0);
        		}
        		if(p3=='1'){
        			return new bldgFooter(1);
        		}
        		if(p3=='2'){
        			return new bldgFooter(2);
        		}
        		if(p3=='3'){
        			return new bldgFooter(3);
        		}
        		if(p3=='4'){
        			return new bldgFooter(4);
        		}
        	}
        	
        }
        if(p1=='h'){
            if(p2=='s'){
                if(p3=='1'){
                    return new houseA();
                }
                if(p3=='2'){
                    return new houseB();
                }
            }
        }
        else if(p1=='p'){
            if(p2=='h'){
            	if(p3=='1'){
                    return new hPowerLine(0);
                }
                if(p3=='2'){
                    return new hPowerLine(1);
                }
                if(p3=='3'){
                    return new hPowerLine(2);
                }
            }
        }
        else if(p1=='r'){
        	if(p2=='f'){
        		if(p3=='1'){
        			return new bldgRoof(1);
        		}
        	}
            if(p2=='k'){
                if(p3=='1'){
                    return new rock();
                }
            }
        }
        else if(p1=='s'){
            if(p2=='d'){
                if(p3=='0'){
                    return new bldgSide(0);
                }
                if(p3=='1'){
                    return new bldgSide(1);
                }
                if(p3=='2'){
                    return new bldgSide(2);
                }
                if(p3=='3'){
                    return new bldgSide(3);
                }
                if(p3=='4'){
                    return new bldgSide(4);
                }
                if(p3=='5'){
                    return new bldgSide(5);
                }
            }
            if(p2=='p'){
            	if(p3=='t'){
            		return new savePoint();
            	}
            }
        }
        else if(p1=='t'){
        	 if(p2=='p'){
                 if(p3=='1'){
                     return new bldgTop(1);
                 }
             }
            if(p2=='r'){
                if(p3=='e'){
                    return new tree();
                }
            }
        }
        else if(p1=='v'){
            if(p2=='w'){
                if(p3=='1'){
                    return new vWall(0);
                }
                if(p3=='2'){
                    return new vWall(1);
                }
                if(p3=='3'){
                    return new vWall(2);
                }
            }
        }
        else if(p1=='w'){
        	if(p2=='l'){
        		if(p3=='1'){
        			return new bldgFacade(0);
        		}
        		if(p3=='2'){
        			return new bldgFacade(1);
        		}
        		if(p3=='3'){
        			return new bldgFacade(2);
        		}
        	}
        }
        if(p1=='B'){
        	if(p2=='D'){
        		if(p3=='1'){
        			return new bldgDecal(10);
        		}
        		
        	}
        }
        return null;
    }
}

//
// Created by TONY DE FREITAS on 24/02/2021.
//

#include <stdlib.h>
#include "blockchain.h"
#include "block.h"

char* getHashCodePredecessor(Blockchain *blockchain){
    return blockchain->blocks[blockchain->nextBlock]->hashCode;
}

Blockchain *initBlockchain(int difficulty, int length){
    Blockchain *blockchain = malloc(sizeof(Blockchain));
    blockchain->difficulty = difficulty;
    blockchain->nextBlock = 0;
    blockchain->length = length;
    blockchain->blocks = malloc(length * sizeof(Block*));
    return blockchain;
}

Block *addBlock(Blockchain *blockchain){
    //Block *block = initBlock(getHashCodePredecessor(blockchain));
    Block *block = initBlock("hdfsdsdfhjhjkhjkfgfgfdfggfgffgfdfgdghjkjkhfdsghjkfghjkgfhjkhjkdg");
    blockchain->blocks[blockchain->nextBlock++] = block;
    return block;
}

void deleteBlockchain(Blockchain *blockchain){
    for(int i = 0; i < blockchain->length; i++){
        //free(blockchain->blocks[i]->txList->tx);
        free(blockchain->blocks[i]->txList);
        free(blockchain->blocks[i]);
    }
    free(blockchain->blocks);
    free(blockchain);
}